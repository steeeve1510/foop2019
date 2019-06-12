note
	description: "Summary description for {LAYER_COMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"
class
	LAYER_COMMAND
inherit
	COMMAND
feature
	execute(player : PLAYER; game: GAME)
	local
		curr_pos: POSITION
		new_sub: SUBWAY
	do
		curr_pos := player.get_position
		--TODO game.get_board.get_subways
		new_sub := find_subway_w_entrance (curr_pos.get_coordinate, game.get_board.get_subways)
		if new_sub /= void then
			if curr_pos.is_on_surface then
				--enter subway
				player.set_position (create {POSITION}.make ( curr_pos.get_coordinate, new_sub))
				new_sub.update_cats (game.get_cats)
				if new_sub.get_id = game.get_goal_subway.get_id then
					player.win
				end
			elseif new_sub = curr_pos.get_layer then
				-- exit to surface
				--print ("Exit to surface %N")
				player.set_position (create {POSITION}.make ( curr_pos.get_coordinate, game.get_board.get_surface))
			end
		else
			print ("No entrance here "+ curr_pos.get_coordinate.out+" %N")
		end
	end

	--find_subway_w_entrance (coord : COORDINATE; sub1: SUBWAY; sub2: SUBWAY): detachable SUBWAY
	find_subway_w_entrance (coord : COORDINATE; subs: LINKED_LIST[SUBWAY]): detachable SUBWAY
	do
		Result := void
		across subs as sub_i loop
			if coord.is_equal(sub_i.item.get_entrance1) or coord.is_equal(sub_i.item.get_entrance2) then
				Result := sub_i.item
			end
		end
	end
end
