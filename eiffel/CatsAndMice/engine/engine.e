note
	description: "Summary description for {ENGINE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENGINE
create
	make
feature
	make (a_game:GAME; a_view: VIEW; a_user: detachable PLAYER)
	do
		game := a_game
		view := a_view
		user := a_user
	end
feature
	run
	local
		stop: BOOLEAN
		frame, finished : INTEGER
		mice: LINKED_LIST [MOUSE]
		cats: LINKED_LIST [CAT]
		players: LINKED_LIST [PLAYER]
		subs: LINKED_LIST [SUBWAY]
	do
		subs := game.get_board.get_subways
		across subs as subi loop
			print("Subway "+ subi.item.out+"%N")
		end
		print("Goal is subway "+ game.get_goal_subway.get_id.out+ "%N")
		io.putstring ("Press ENTER to continue.")
		io.read_character
		--Game Loop
		from
			stop := false
			frame := 0
		until
			stop or frame > 100
		loop
			finished := 0
			check_collisions
			view.render(game, user)
			cats := game.get_cats
			across cats as cat loop
				cat.item.make_move (game)
			end
			mice := game.get_mice
			across mice as mouse loop
				mouse.item.make_move (game)
				if mouse.item.has_won or mouse.item.is_dead then
					finished := finished +1
				end
			end
			game.frame_inc
			stop := finished = mice.count
			frame := frame + 1
		end
		players := game.get_players
			across players as play loop
				print(play.item.out + "%N")
			end
	end

	check_collisions
	local
		mice: LINKED_LIST[MOUSE]
		cats: LINKED_LIST[CAT]
		cat_coords: LINKED_LIST[COORDINATE]
		mouse_coord: COORDINATE
	do
		cats := game.get_cats
		create cat_coords.make
		across cats as cat_i loop
			cat_coords.extend (cat_i.item.get_position.get_coordinate)
		end
		mice := game.get_mice
		across mice as mouse_i loop
			if not mouse_i.item.is_dead and then mouse_i.item.is_on_surface then
				mouse_coord := mouse_i.item.get_position.get_coordinate
				if across cat_coords as cat_i some cat_i.item.is_equal(mouse_coord) end then
					mouse_i.item.kill
					print ("Mouse killed at " + mouse_coord.out + "%N")
				end
			end
		end
	end
feature {NONE}
	game : GAME
	view : VIEW
	user : detachable PLAYER
end
