note
	description: "Summary description for {OVER_VIEW}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	OVER_VIEW
inherit
	VIEW
feature
	render(game: GAME; player: detachable PLAYER)
	local
		players: LINKED_LIST [PLAYER]
	do
		print("Frame: " + game.get_frame.out + "%N")
		players := game.get_players
		across players as play loop
			print(play.item.out + "%N")
		end
	end
end
