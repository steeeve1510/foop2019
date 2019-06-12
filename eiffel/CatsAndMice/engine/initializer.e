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
	init_game(seed: INTEGER): GAME
	require
		non_negative: seed >= 0
	local
		surface : SURFACE
		board : BOARD
		mice: LINKED_LIST[MOUSE]
		cats: LINKED_LIST[CAT]
		game : GAME
		subways: LINKED_LIST[SUBWAY]
	do
		create surface
		subways := init_subways(seed)
		create board.make(configuration.get_width, configuration.get_height, surface, subways)
		mice := init_mice(seed, subways)
		cats := init_cats(seed, surface)
		create game.make(board, subways.at (configuration.get_number_subways), mice, cats)
		Result := game
	ensure
		Result /= void
	end
feature {NONE} -- private methods
	init_subways(seed: INTEGER): LINKED_LIST [SUBWAY]
	local
		subways: LINKED_LIST [SUBWAY]
		stop: BOOLEAN
		a_x, a_y, i: INTEGER
		entrances: LINKED_LIST[COORDINATE]
		coord1, coord2: COORDINATE
		RNG: RANDOM
	do
		create subways.make
		create entrances.make
		create coord1.make (0,0)
		create coord2.make (0,0)
		from
		    i := 0
		    create RNG.set_seed (seed)
		    RNG.start
		until
		    i >= configuration.get_number_subways
		loop
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
			    if not (across entrances as ent_i some ent_i.item.is_equal(coord1) end) then
					entrances.extend (coord1)
			    	stop := true
				end
			end
			from
			    stop := false
			until
			    stop = true
			loop
				a_x := RNG.item \\ configuration.get_width
				RNG.forth
				a_y := RNG.item \\ configuration.get_height
				RNG.forth
			    create coord2.make (a_x, a_y)
			    if not (across entrances as ent_i some ent_i.item.is_equal(coord2) end) then
					entrances.extend (coord2)
			    	stop := true
				end
			end
			subways.extend (create {SUBWAY}.make (i, coord1, coord2))
		    i := i + 1
		end
		Result := subways
	ensure
		Result.count = configuration.get_number_subways
	end

	init_mice(seed: INTEGER; subways : LINKED_LIST [SUBWAY]) : LINKED_LIST [MOUSE]
	local
		mice: LINKED_LIST [MOUSE]
		mouse: MOUSE
		stop: BOOLEAN
		a_x, a_y, i: INTEGER
		others: LINKED_LIST[COORDINATE]
		coord1: COORDINATE
		RNG: RANDOM
	do
		create mice.make
		create others.make
		create coord1.make (0,0)
		from
		    i := 0
		    create RNG.set_seed (seed)
		    RNG.start
		until
		    i >= configuration.get_number_mouse_bots
		loop
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
			    if not (across others as ent_i some ent_i.item.is_equal(coord1) end) then
					others.extend (coord1)
			    	stop := true
				end
			end
			create mouse.make(create {POSITION}.make(coord1, subways.at (RNG.item \\ (configuration.get_number_subways - 1) + 1 )), create {MOUSE_BOT_CLIENT})
			mice.extend (mouse)
		    i := i + 1
		end
		Result := mice
	ensure
		Result.count = configuration.get_number_mouse_bots
	end

	init_cats(seed: INTEGER; surface: SURFACE): LINKED_LIST [CAT]
	local
		cats: LINKED_LIST [CAT]
		cat: CAT
		stop: BOOLEAN
		a_x, a_y, i: INTEGER
		others: LINKED_LIST[COORDINATE]
		coord1: COORDINATE
		RNG: RANDOM
	do
		create cats.make
		create others.make
		create coord1.make (0,0)
		from
		    i := 0
		    create RNG.set_seed (seed)
		    RNG.start
		until
		    i >= configuration.get_number_cat_bots
		loop
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
			    if not (across others as ent_i some ent_i.item.is_equal(coord1) end) then
					others.extend (coord1)
			    	stop := true
				end
			end
			create cat.make(create {POSITION}.make(coord1, surface), create {CAT_BOT_CLIENT})
			cats.extend (cat)
		    i := i + 1
		end
		Result := cats
	ensure
		Result.count = configuration.get_number_cat_bots
	end

feature {NONE}
	configuration : CONFIGURATION
end
