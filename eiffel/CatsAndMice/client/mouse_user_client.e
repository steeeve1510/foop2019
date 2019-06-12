note
	description: "Summary description for {MOUSE_USER_CLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSE_USER_CLIENT

inherit
	CLIENT
feature
	get_next_move(game: GAME): detachable COMMAND
	--require
	--	non_void: player /= void
	local
		goals: LINKED_LIST[COORDINATE]
		nearest: COORDINATE
		pos: POSITION
		won: BOOLEAN
	do
		if player /= void then
			pos := player.get_position
			won := false
			create nearest.make (0,0)
			if pos.is_on_surface then
				--if on surface, straight to nearest goal entrance
				create goals.make
				goals.extend (game.get_goal_subway.get_entrance1)
				goals.extend (game.get_goal_subway.get_entrance2)
				nearest := {BOT_UTIL}.get_nearest(pos.get_coordinate, goals)
			else
				--if in subway, get exit which is nearest to goal subway
				if attached {SUBWAY} pos.get_layer as layer_sub  then
					if layer_sub = game.get_goal_subway then
						won := True
					else
						nearest := {BOT_UTIL}.get_nearest_exit(layer_sub, game.get_goal_subway)
					end
				else
					print ("ERROR not a subway %N")
				end
			end
			--print ("Mouse Target:  "+ nearest.out + "%N")
			if nearest.get_x > pos.get_coordinate.get_x then
				--print ("Move right %N")
				Result := create {RIGHT_COMMAND}
			elseif nearest.get_x < pos.get_coordinate.get_x then
				--print ("Move left %N")
				Result := create {LEFT_COMMAND}
			elseif nearest.get_y > pos.get_coordinate.get_y then
				--print ("Move up %N")
				Result := create {UP_COMMAND}
			elseif nearest.get_y < pos.get_coordinate.get_y then
				--print ("Move down %N")
				Result := create {DOWN_COMMAND}
			elseif not won then
				--print ("Change layer %N")
				Result := create {LAYER_COMMAND}
			--else
				--print ("Won%N")
			end
		else
			--raise an exception here? can't do it with require
			Result := void
			--create pos.make( create {COORDINATE}.make(0,0), game.get_board.get_surface)
		end
	end
feature
	game_over
	do
	end
	set_player(m: MOUSE)
	do
		player := m
	end
feature {NONE}
	player: detachable PLAYER
		note
			option: stable
		attribute
		end
end
