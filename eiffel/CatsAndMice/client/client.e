note
	description: "Summary description for {CLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	CLIENT
feature
	get_next_move(game: GAME): detachable COMMAND
	deferred
	end
	game_over
	deferred
	end
	set_player(player: PLAYER)
	deferred
	end
end
