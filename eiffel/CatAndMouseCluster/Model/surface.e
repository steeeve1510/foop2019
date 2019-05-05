note
	description: "Summary description for {SURFACE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SURFACE

inherit
	LAYER

create
	makeSurface

feature  -- Initialization

	makeSurface
			-- Initialization for `Current'.
		do

		end

	equals(that:LAYER):BOOLEAN
		do

			if attached ({SURFACE} / that) then
				Result:= true
			else
				Result:= false
			end
		end
end
