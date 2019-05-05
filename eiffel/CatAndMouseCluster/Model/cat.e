note
	description: "Summary description for {CAT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CAT

inherit
	PLAYER

create
	makeCat

feature -- Initialization

	catClient: CATCLIENT
	position: POSITION

	makeCat(catClientParam: CATCLIENT; positionParam: POSITION)
			-- Initialization for `Current'.
		do
			catClient:=catClientParam
			position:= positionParam
		end

	isDead : BOOLEAN
		do
			Result:= false
		end

	getNextMove : COMMAND
		do
			Result:= catClient.getNextMove
		end

	getPosition : POSITION
		do
			Result:= position
		end

	setPosition (positionParam: POSITION)
		do
			position:= positionParam
		end

	gameOver(winner: STRING)
		do
			catClient.gameOver(winner)
		end

	update(game: GAME)
		local
			miceOnSurface: LINKED_SET[MOUSE]
			cats,aliveMiceOnSurface, deadMiceOnSurface, subwayEntrances : LINKED_SET [COORDINATE]
			catView: CATVIEW

		do
			create cats.make
			create miceOnSurface.make
			create aliveMiceONSurface.make
			create deadMiceOnSurface.make
			create subwayEntrances.make

			across game.cats as currentCat loop
				cats.put (currentCat.item.position.coordinate)
			end

			across game.mice as currentMouse loop
				if currentMouse.item.position.layer.equals(game.board.surface) then
					miceOnSurface.put (currentMouse.item)
				end
			end

			across miceOnSurface as currentMouse2 loop
				if currentMouse2.item.isDead = true then
					deadMiceOnSurface.put (currentMouse2.item.position.coordinate)
				else
					aliveMiceOnSurface.put (currentMouse2.item.position.coordinate)
				end
			end

			across game.board.subways as subway loop
				across subway.item.entrances as entrance loop
					subwayentrances.put (entrance.item)
				end
			end

			create catView.makecatview (position, cats, aliveMiceOnSurface, deadMiceOnSurface, subwayEntrances)
			catClient.render(catView)
		end
end
