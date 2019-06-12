note
	description: "Summary description for {GAME}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"
class
	GAME
create
	make
feature
	make(a_board: BOARD; goal: SUBWAY; a_mice: LINKED_LIST[MOUSE]; a_cats: LINKED_LIST[CAT])
	do
		board := a_board
		frame := 0
		goal_subway := goal
		mice := a_mice
		cats := a_cats 
	end
feature
	get_board: BOARD
	do
		Result := board
	end
	get_frame: INTEGER
	do
		Result := frame
	end
	get_goal_subway: SUBWAY
	do
		Result := goal_subway
	end
	get_mice: LINKED_LIST [MOUSE]
	do
		Result := mice
	end
	get_cats:  LINKED_LIST [CAT]
	do
		Result := cats
	end
	get_players: LINKED_LIST [PLAYER]
	local
		players : LINKED_LIST [PLAYER]
	do
		create players.make
		players.append (get_mice)
		players.append (get_cats)
		Result := players
	end
feature
	frame_inc
	do
		frame := frame +1
	end
	add_cat(cat :CAT)
	do
		cats.extend (cat)
	end
	add_mouse(mouse :MOUSE)
	do
		mice.extend (mouse)
	end
feature {NONE}
	board: BOARD
	frame: INTEGER
	goal_subway: SUBWAY
	mice: LINKED_LIST[MOUSE]
	cats: LINKED_LIST[CAT]
end
