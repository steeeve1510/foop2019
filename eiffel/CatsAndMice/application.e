note
	description: "CatsAndMice application root class"
	date: "$Date$"
	revision: "$Revision$"

class
	APPLICATION
inherit
	ARGUMENTS_32 -- required for using command line arguments
create
	make
feature {NONE} -- Initialization
	make
		local
			initer: INITIALIZER
			config: CONFIGURATION
			engine: ENGINE
			game_tuple: TUPLE [game: GAME; player: detachable PLAYER]
			user: PLAYER
			game: GAME
			view: VIEW
			--width, height, cats, mice, subs, player_num : INTEGER
			params: TUPLE[h,w,c,m,s,p,se:INTEGER]
		do
			io.putstring ("%N*********************************%N")
			io.putstring ("%T Cats and Mice Game%N")
			io.putstring ("*********************************%N")
			-- height, width , win_h, win_w, cats, mice, subs
			params := get_game_parameters
			--create config.make(10, 10, 1, 1, 2, 4, 3)
			create config.make(params.h, params.w, 1, 1, params.c, params.m, params.s)
			create initer.make(config)
			game_tuple := initer.init_game(params.se, params.p)
			game := game_tuple.game
			user := game_tuple.player
			inspect params.p
				when 1 then
					view := create {CAT_VIEW}
				when 2 then
					view := create {MOUSE_VIEW}
				else
					view := create {OVER_VIEW}
			end
			create engine.make(game, view, user)
			engine.run
		end
feature
	get_game_parameters: TUPLE[h,w,c,m,s,p,se:INTEGER]
							-- width , height,	cats,	mice,		subs, 	player
	local
		width, height, cats, mice, subs, player_num, seed : INTEGER
	do
		io.putstring("Introduce board width (>=2): ")
		width := get_valid_parameter(2,80)
		io.putstring("Introduce board height(>=2): ")
		height := get_valid_parameter(2,80)
		io.putstring("Introduce number of cat bots: ")
		cats := get_valid_parameter(1, (width*height)-2)
		io.putstring("Introduce number of mouse bots: ")
		mice := get_valid_parameter(1, cats*2)
		io.putstring("Introduce number of subways (>= 2): ")
		subs := get_valid_parameter(1, ((width*height)/2).floor)
		io.putstring("Enter player class (1=cat,2=mouse,0=no intervention): ")
		player_num := get_valid_parameter(0, 3)
		io.putstring("Enter random seed (>0): ")
		seed := get_valid_parameter(0, 10000)
        Result := [width, height, cats, mice, subs, player_num, seed]
	end

	get_valid_parameter(min: INTEGER; max: INTEGER): INTEGER
	require
		valid_range: min <= max
	local
		value: INTEGER
		valid: BOOLEAN
	do
		from
			valid := false
		until
			valid
		loop
			io.read_integer
			value := io.last_integer
			if value >= min and value <= max then
				valid := true
				Result := value
			else
				print ("Invalid parameter: range=["+ min.out +","+max.out +"] %N Reintroduce: ")
			end
		end
	ensure
		Result <= max and Result >= min
	end
end
