note
	description: "Summary description for {INITIALIZER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	INITIALIZER
create
	make
feature
	make (a_config: CONFIGURATION)
	do
		configuration := a_config
	end
feature
	init_game(seed: INTEGER; player_class: INTEGER): TUPLE [game: GAME; user: detachable PLAYER]
	require
		non_negative: seed >= 0
	local
		surface : SURFACE
		board : BOARD
		mice: LINKED_LIST[MOUSE]
		cats: LINKED_LIST[CAT]
		game : GAME
		subways: LINKED_LIST[SUBWAY]
		user: PLAYER
		user_cat: CAT
		user_mouse: MOUSE
		RNG: RANDOM
		start_pos: COORDINATE
	do
		create surface
		create RNG.set_seed (seed)
		RNG.start
		subways := init_subways(RNG)
		create board.make(configuration.get_width, configuration.get_height, surface, subways)
		mice := init_mice(RNG, subways)
		cats := init_cats(RNG, surface)
		if player_class = 1 then --cat
			start_pos := get_free_location(RNG, void)
			user_cat := create {CAT}.make(create {POSITION}.make(start_pos, surface), create {CAT_USER_CLIENT})
			print("User starts at: " + start_pos.out + "%N")
			cats.extend (user_cat)
		elseif player_class = 2 then --mouse
			start_pos := get_free_location(RNG, void)
			user_mouse := create {MOUSE}.make(create {POSITION}.make(start_pos, subways.at (RNG.item \\ (configuration.get_number_subways - 1) + 1 )), create {MOUSE_USER_CLIENT})
			print("User starts at: " + start_pos.out + "%N")
			mice.extend (user_mouse)
		end
		create game.make(board, subways.at (configuration.get_number_subways), mice, cats)
		if user_mouse /= void then
			user := user_mouse
		elseif user_cat /= void	then
			user := user_cat
		else
			user := void
		end
		Result := [game, user]
	ensure
		Result /= void
	end
feature {NONE} -- private methods
	init_subways(RNG: RANDOM): LINKED_LIST [SUBWAY]
	local
		subways: LINKED_LIST [SUBWAY]
		stop: BOOLEAN
		i: INTEGER
		entrances: LINKED_LIST[COORDINATE]
		coord1, coord2: COORDINATE
	do
		create subways.make
		create entrances.make
		create coord1.make (0,0)
		create coord2.make (0,0)
		from
		    i := 0
		until
		    i >= configuration.get_number_subways
		loop
			coord1 := get_free_location(RNG, entrances)
			entrances.extend (coord1)
			coord2 := get_free_location(RNG, entrances)
			entrances.extend (coord2)
			subways.extend (create {SUBWAY}.make (i, coord1, coord2))
		    i := i + 1
		end
		Result := subways
	ensure
		Result.count = configuration.get_number_subways
	end

	init_mice(RNG: RANDOM; subways : LINKED_LIST [SUBWAY]) : LINKED_LIST [MOUSE]
	local
		mice: LINKED_LIST [MOUSE]
		mouse: MOUSE
		stop: BOOLEAN
		i: INTEGER
		others: LINKED_LIST[COORDINATE]
		coord1: COORDINATE
	do
		create mice.make
		create others.make
		create coord1.make (0,0)
		from
		    i := 0
		until
		    i >= configuration.get_number_mouse_bots
		loop
			coord1 := get_free_location(RNG, others)
			others.extend (coord1)
			create mouse.make(create {POSITION}.make(coord1, subways.at (RNG.item \\ (configuration.get_number_subways - 1) + 1 )), create {MOUSE_BOT_CLIENT})
			RNG.forth
			mice.extend (mouse)
		    i := i + 1
		end
		Result := mice
	ensure
		Result.count = configuration.get_number_mouse_bots
	end

	init_cats(RNG: RANDOM; surface: SURFACE): LINKED_LIST [CAT]
	local
		cats: LINKED_LIST [CAT]
		cat: CAT
		stop: BOOLEAN
		i: INTEGER
		others: LINKED_LIST[COORDINATE]
		coord1: COORDINATE
	do
		create cats.make
		create others.make
		create coord1.make (0,0)
		from
		    i := 0
		until
		    i >= configuration.get_number_cat_bots
		loop
			coord1 := get_free_location(RNG, others)
			others.extend (coord1)
			create cat.make(create {POSITION}.make(coord1, surface), create {CAT_BOT_CLIENT})
			cats.extend (cat)
		    i := i + 1
			RNG.forth
		end
		Result := cats
	ensure
		Result.count = configuration.get_number_cat_bots
	end

	get_free_location(RNG: RANDOM; others: detachable LINKED_LIST[COORDINATE]): COORDINATE
	local
		stop: BOOLEAN
		a_x, a_y: INTEGER
		coord1: COORDINATE
	do
		create coord1.make (0,0)
		from
		    stop := false
		until
		    stop = true
		loop
			a_x := RNG.item \\ configuration.get_width
			RNG.forth
			a_y := RNG.item \\ configuration.get_height
			RNG.forth
		    create coord1.make (a_x, a_y)
		    if others /= void then
		    	if not (across others as ent_i some ent_i.item.is_equal(coord1) end) then
		    		stop := true
				end
			else
				stop:= true
		    end
		end
		Result:= coord1
	end

feature {NONE}
	configuration : CONFIGURATION
end
