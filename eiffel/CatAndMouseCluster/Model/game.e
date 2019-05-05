note
	description: "Summary description for {GAME}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	GAME

create
	makeGame

feature -- Initialization

	frameCounter: INTEGER
	board: BOARD
	goalSubway: SUBWAY
	mice: LINKED_SET[ MOUSE ]
	cats: LINKED_SET [ CAT ]

	makeGame(boardParam: BOARD; goalSubwayParam: SUBWAY; miceParam: LINKED_SET [ MOUSE ]; catsParam: LINKED_SET [ CAT ])
			-- Initialization for `Current'.
		do
			frameCounter:=0
			board:=boardParam
			goalSubway:=goalSubwayParam
			mice:=miceParam
			cats:=catsParam
		end

end
