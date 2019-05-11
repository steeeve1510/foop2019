note
	description: "Summary description for {MOUSE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSE

inherit
	PLAYER

create
	makeMouse

feature  -- Initialization

	mouseClient: MOUSECLIENT
	position: POSITION
	dead: BOOLEAN

	makeMouse(mouseClientParam: MOUSECLIENT; positionParam: POSITION)
			-- Initialization for `Current'.
		do
			mouseClient:=mouseClientParam
			position:=positionParam
			mouseClient.setMouse(Current)
		end

	isDead: BOOLEAN
		do
			Result:= dead
		end

	getNextMove:COMMAND
		do
			Result:= mouseClient.getNextMove
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
			mouseClient.gameOver(winner)
		end

	update(game: GAME)
		local
			miceOnCurrentLayer: LINKED_SET [MOUSE]
			cats, aliveMiceOnCurrentLayer, deadMiceOnCurrentLayer, subwayEntrances : LINKED_SET [COORDINATE]
			goalSubway, currentSubway: SUBWAY
			mouseView: MOUSEVIEW
			a_any:ANY

		do
			create cats.make
			create alivemiceoncurrentlayer.make
			create deadmiceoncurrentlayer.make
			create subwayentrances.make
			create miceoncurrentlayer.make

			across game.mice as currentMouse loop
				if currentMouse.item.position.layer.equals(position.layer) then
					miceOnCurrentLayer.put (currentMouse.item)
				end
			end

			across miceOnCurrentLayer as currentMouse loop
				if currentMouse.item.isDead = true then
					deadMiceOnCurrentLayer.put (currentMouse.item.position.coordinate)
				else
					aliveMiceOnCurrentLayer.put (currentMouse.item.position.coordinate)
				end
			end

			if position.isOnSurface then
				across game.cats as currentCat loop
					if currentCat.item.position.layer.equals(position.layer) then
						cats.put (currentCat.item.position.coordinate)
					end
				end
			else
				currentSubway ?= position.layer
				if currentSubway /= void then
					cats := currentsubway.catslastseen
				end
			end

			goalSubway:=game.goalsubway

			create mouseView.makemouseview (dead, position, aliveMiceOnCurrentLayer, deadMiceOnCurrentLayer, cats,goalSubway)
			mouseClient.render (mouseView)
		end
end
