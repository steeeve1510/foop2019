note
	description: "Summary description for {SURFACE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	SURFACE
inherit
	LAYER
feature
	is_surface: BOOLEAN
	do
		Result:= True
	end
end
