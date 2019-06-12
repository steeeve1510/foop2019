note
	description: "Summary description for {POSITION}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"
class
	POSITION
inherit
	ANY
		redefine
			out
		end
create
	make
feature
	make(xy: COORDINATE; a_layer: LAYER)
	do
		coordinate := xy
		layer := a_layer
	end
feature
	get_coordinate: COORDINATE
	do
		Result := coordinate
	end
	get_layer: LAYER
	do
		Result := layer
	end
	is_on_surface: BOOLEAN
	do
		Result := layer.is_surface
	end
feature {NONE}
	coordinate: COORDINATE
	layer: LAYER
feature
	out: STRING
	do
		if attached {SUBWAY} layer as sub then
            Result := coordinate.out + " at sub " + sub.get_id.out
        else
			Result := coordinate.out + " surface"
		end
	end
end
