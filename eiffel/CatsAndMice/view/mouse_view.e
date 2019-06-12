note
	description: "Summary description for {MOUSE_VIEW}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSE_VIEW
inherit
	VIEW
feature
	render(game: GAME; player: detachable PLAYER)
	local
		players: LINKED_LIST [PLAYER]
		layer: LAYER
		cats: LINKED_LIST[COORDINATE]
	do
		players := game.get_players
		if player = void then
			layer := game.get_board.get_surface
		else
			layer := player.get_position.get_layer
		end
		if attached {SUBWAY} layer as sub then
			cats := sub.get_cats
			across players as play loop
				if layer.is_equal(play.item.get_position.get_layer) then
					print(play.item.out + "%N")
				end
			end
			if cats /= void then
				print ("Cats last seen: %N")
				across cats as cat loop
					print(cat.item.out + "%N")
				end
			end
		else
			across players as play loop
				if play.item.get_position.is_on_surface then
					print(play.item.out + "%N")
				end
			end
		end
	end
end
