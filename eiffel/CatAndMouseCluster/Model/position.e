note
	description: "Summary description for {POSITION}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	POSITION

create
	makePosition

feature  -- Initialization
	coordinate: COORDINATE
	layer: LAYER
	makePosition (coordinateParam: COORDINATE; layerParam:LAYER)
			-- Initialization for `Current'.
		do
			coordinate:=coordinateParam
			layer:=layerParam
		end

	equals (that: POSITION) : BOOLEAN
			-- checks whether two coordinates are equal
		do
			if that.coordinate.equals (coordinate) and that.layer=layer then
				Result:= true
			else
				Result:= false
			end
		end

	isOnSurface: BOOLEAN
		do
			Result:= {layer}={SURFACE}
		end
end
