note
	description: "Summary description for {COORDINATE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	COORDINATE

create
	makeCoord

feature -- Initialization

	x: INTEGER
	y: INTEGER
	makeCoord (xNew: INTEGER; yNew:INTEGER)
			-- Initialization for `Current'.
		do
			x:= xNew
			y:= yNew
		end

	equals (that: COORDINATE) : BOOLEAN
			-- checks whether two coordinates are equal
		do
			if that.x=x and that.y=y then
				Result:= true
			else
				Result:= false
			end
		end
end
