note
	description: "Summary description for {MOVELEFTCOMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOVELEFTCOMMAND

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
		do
			if executed = false then
				currentCoordinate := player.getposition.coordinate
				currentLayer:=player.getposition.layer
				if 0 < currentCoordinate.x then
					create newCoordinate.makecoord (currentCoordinate.x-1, currentCoordinate.y)
					create newPosition.makeposition (newCoordinate, currentLayer)
					player.setposition (newPosition)
					executed:=true
				end
			end
		end

end
