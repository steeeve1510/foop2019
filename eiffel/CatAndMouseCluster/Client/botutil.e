note
	description: "Summary description for {BOTUTIL}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	BOTUTIL

feature
	getNearest(ref: COORDINATE; others: LINKED_SET[COORDINATE]) : COORDINATE
		local
			currentMinDist: INTEGER
			currentMinCoord: COORDINATE
		do
			create currentMinCoord.makecoord (0,0)
			if others = Void then
			--	Result:= Void
			else
				currentMinDist:=1000
				across others as coord loop
					if getDistance(ref,coord.item)<currentMinDist then
						currentMinDist:= getDistance(ref,coord.item)
						currentMinCoord:= coord.item
					end
				end
			end
			Result:=currentmincoord
		end

	getDistance(c1, c2: COORDINATE) : INTEGER
		do
			Result:=(c1.x-c2.x).abs+(c1.y-c2.y).abs
		end
end
