note
	description: "Summary description for {CAT_VIEW}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CAT_VIEW
inherit
	VIEW
feature
	render(game: GAME; player: detachable PLAYER)
	local
		players: LINKED_LIST [PLAYER]
		layer: LAYER
	do
		players := game.get_players
		across players as play loop
			if play.item.get_position.is_on_surface then
				print(play.item.out + "%N")
			end
		end
	end
end
