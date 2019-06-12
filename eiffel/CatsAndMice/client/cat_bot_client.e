note
	description: "Summary description for {CAT_BOT_CLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CAT_BOT_CLIENT
inherit
	CLIENT
feature
	get_next_move(game: GAME): detachable COMMAND
	local
		goals: LINKED_LIST[COORDINATE]
		mice: LINKED_LIST[MOUSE]
		nearest, current_coord: COORDINATE
	do
		if player /= void then
			current_coord := player.get_position.get_coordinate
			nearest := current_coord
			-- straight to nearest mouse on surface
			create goals.make
			mice := game.get_mice
			across mice as mouse_i loop
				if mouse_i.item.get_position.is_on_surface and not mouse_i.item.is_dead then
					goals.extend (mouse_i.item.get_position.get_coordinate)
				end
			end
			if goals.count > 0 then
				nearest := {BOT_UTIL}.get_nearest(current_coord, goals)
			end
			--print ("Cat Target:  "+ nearest.out + "%N")
			if nearest.get_x > current_coord.get_x then
				--print ("Move right %N")
				Result := create {RIGHT_COMMAND}
			elseif nearest.get_x < current_coord.get_x then
				--print ("Move left %N")
				Result := create {LEFT_COMMAND}
			elseif nearest.get_y > current_coord.get_y then
				--print ("Move up %N")
				Result := create {UP_COMMAND}
			elseif nearest.get_y < current_coord.get_y then
				--print ("Move down %N")
				Result := create {DOWN_COMMAND}
			--else
				--print ("Don't move %N")
			end
		else
			--raise exception
			Result := void
			--create current_coord.make (0, 0)
		end
	end
feature
	game_over
	do
	end
	set_player(a_cat: PLAYER)
	do
		player := a_cat
	end
feature {NONE}
	player: detachable PLAYER assign set_player
		note
			option: stable
		attribute
		end
end
