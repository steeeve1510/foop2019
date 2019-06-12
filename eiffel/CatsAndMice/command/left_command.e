note
	description: "Summary description for {LEFT_COMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"
class
	LEFT_COMMAND
inherit
	COMMAND
feature
	execute(player : PLAYER; game: GAME)
	local
		curr_pos: POSITION
		a_x, a_y: INTEGER
	do
		curr_pos := player.get_position
		a_y := curr_pos.get_coordinate.get_y
		a_x := curr_pos.get_coordinate.get_x
		if a_x > 0 then
			player.set_position (create {POSITION}.make ( create {COORDINATE}.make (a_x -1, a_y), curr_pos.get_layer))
		end
	end
end
