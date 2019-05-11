note
	description: "Summary description for {MOVERIGHTCOMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOVERIGHTCOMMAND

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
			maxWidth: INTEGER
		do
			if executed = false then
				maxWidth:=game.board.width
				currentCoordinate := player.getposition.coordinate
				currentLayer:=player.getposition.layer
				if maxWidth > currentCoordinate.x+1 then
					create newCoordinate.makecoord (currentCoordinate.x+1, currentCoordinate.y)
					create newPosition.makeposition (newCoordinate, currentLayer)
					player.setposition (newPosition)
					executed:=true
				end
			end
		end

end
