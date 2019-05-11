note
	description: "Summary description for {CATBOTCLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CATBOTCLIENT

inherit
	CATCLIENT

feature
	cat: CAT
	view: CATVIEW

	render(viewParam: CATVIEW)
		do
			view:=viewParam
		end
	setCat(catParam:CAT)
		do
			cat:=catParam
		end
	getNextMove:COMMAND
		local
			currentCoordinate: COORDINATE
			mouse :COORDINATE
			xDiff: INTEGER
			yDiff: INTEGER
			botUtil: BOTUTIL

			moveLeftCommand:MOVELEFTCOMMAND
			moveRightCommand: MOVERIGHTCOMMAND
			moveUpCommand: MOVEUPCOMMAND
			moveDownCommand: MOVEDOWNCOMMAND
		do
			if view= Void then
				Result:= Void
			else
				currentCoordinate:=view.currentposition.coordinate
				mouse:= botUtil.getnearest (currentCoordinate, view.mice)
				if mouse = Void then
					Result:=Void
				end
				xDiff:=currentcoordinate.x-mouse.x
				yDiff:=currentcoordinate.y-mouse.y
				if xDiff>0 then
					Result:= create moveleftcommand.make (cat)
				if  then

				end
			end
		end

	gameOver(winner:String)
		do
			--should remain empty
		end
end
