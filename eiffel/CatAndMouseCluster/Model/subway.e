note
	description: "Summary description for {SUBWAY}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SUBWAY
inherit
	LAYER

create
	makeSubway

feature  -- Initialization
	id: INTEGER
	entrances:  LINKED_SET [COORDINATE]
	catsLastSeen :  LINKED_SET [COORDINATE]

	makeSubway (c:COUNTER; entr: LINKED_SET [COORDINATE])
			-- Initialization for `Current'.
		do
			id:=c.newSubway
			entrances:= entr
			create catsLastSeen.make
		end

	equals(that:LAYER):BOOLEAN
		do

			if attached ({SUBWAY} / that) then
				Result:= true
			else
				Result:= false
			end
		end

end
