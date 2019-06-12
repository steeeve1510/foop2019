note
	description: "CatsAndMice application root class"
	date: "$Date$"
	revision: "$Revision$"

class
	APPLICATION

inherit
	ARGUMENTS_32

create
	make

feature {NONE} -- Initialization

	make
		local
			initer: INITIALIZER
			config: CONFIGURATION
			engine: ENGINE
			game: GAME
			view: VIEW
		do
			-- height, width , win_h, win_w, cats, mice, subs
			create config.make(10, 10, 1, 1, 2, 4, 3)
			create initer.make(config)
			game := initer.init_game
			view := create {OVER_VIEW}
			create engine.make(game, view, void)
			engine.run
		end

end
