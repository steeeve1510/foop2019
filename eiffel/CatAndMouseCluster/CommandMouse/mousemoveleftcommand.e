note
	description: "Summary description for {MOUSEMOVELEFTCOMMAND}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSEMOVELEFTCOMMAND

inherit
	COMMAND

create
	make

feature  -- Initialization
	mouse:MOUSE
	executed:BOOLEAN

	make(mouseParam:MOUSE)
			-- Initialization for `Current'.
		do
			mouse:=mouseParam
		end
	execute(game:GAME)
		local
			move: MOVELEFTCOMMAND
		do
			if executed=false and game.framecounter\\2 = 1 then
				create move.make (mouse)
				move.execute (game)
				executed:= true
			end
		end

end
