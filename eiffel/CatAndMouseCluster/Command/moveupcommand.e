note
	description: "Summary description for {MOVEUPCOMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOVEUPCOMMAND

inherit
	COMMAND

create
	make

feature  -- Initialization

	player: PLAYER
	executed: BOOLEAN

	make (playerParam: PLAYER)
			-- Initialization for `Current'.
		do
			executed:=false
			player:= playerParam
		end

	execute (game: GAME)
		local
			currentCoordinate : COORDINATE
			currentLayer : LAYER
			newCoordinate: COORDINATE
			newPosition: POSITION
			maxHeight: INTEGER
		do
			if executed = false then
				maxHeight:=game.board.height
				currentCoordinate := player.getposition.coordinate
				currentLayer:=player.getposition.layer
				if maxHeight > currentCoordinate.y+1 then
					create newCoordinate.makecoord (currentCoordinate.x, currentCoordinate.y+1)
					create newPosition.makeposition (newCoordinate, currentLayer)
					player.setposition (newPosition)
					executed:=true
				end
			end
		end
end
