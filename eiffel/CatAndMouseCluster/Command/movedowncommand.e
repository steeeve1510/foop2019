note
	description: "Summary description for {MOVEDOWNCOMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOVEDOWNCOMMAND

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
				if 0 < currentCoordinate.y then
					create newCoordinate.makecoord (currentCoordinate.x, currentCoordinate.y-1)
					create newPosition.makeposition (newCoordinate, currentLayer)
					player.setposition (newPosition)
					executed:=true
				end
			end
		end
end
