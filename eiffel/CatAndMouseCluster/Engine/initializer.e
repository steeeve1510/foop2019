note
	description: "Summary description for {INITIALIZER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	INITIALIZER

create
	make

feature  -- Initialization
	config: CONFIG
	make(configParam: CONFIG)
			-- Initialization for `Current'.
		do
			config:=configParam
		end

	initializeGame : GAME
		local
			surface: SURFACE
			subways: LINKED_SET[SUBWAY]
			board: BOARD

--			catClient: CATUSERCLIENT
--			cat: CAT
			catBotClient: CATBOTCLIENT
--			catBot: CAT
--			cats: LINKED_SET[MOUSE]

--			mouseClient: MOUSEUSERCLIENT
--			mouse: MOUSE
--			mouseBotClient: MOUSEBOTCLIENT
--			mouseBot: MOUSE
--			mice: LINKED_SET[MOUSE]
		do

		end

--	createSubway(subways : LINKED_SET[SUBWAY]):SUBWAY
--		do

--		end

--	getNewEntrance(maxHEight, maxWidth: INTEGER; usedEntrances, chosenEntrances: LINKED_SET[COORDINATE]): COORDINATE
--		do

--		end

--	getRandomCoordinate(maxHEight, maxWidth: INTEGER): COORDINATE
--		do

--		end

--	getCate (catClient: CATCLIENT; surface: SURFACE):CAT
--		do

--		end
--	getMouse(mouseClient: MOUSECLIENT; subways: LINKED_SET[SUBWAY])
--		do
--			
--		end

end
