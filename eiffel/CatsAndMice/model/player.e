note
	description: "Summary description for {PLAYER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"
deferred class
	PLAYER
feature
	set_position(position: POSITION) deferred end
	--update deferred end
	make_move(game: GAME) deferred end
	set_last_action(frame: INTEGER) deferred end
	win deferred end
feature
	get_position: POSITION deferred end
	is_dead: BOOLEAN deferred end
	has_won: BOOLEAN deferred end
	get_last_action: INTEGER deferred end
end
