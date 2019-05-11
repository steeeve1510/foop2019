note
	description: "Summary description for {BOARD}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	BOARD

create
	makeBoard

feature -- Initialization

	width: INTEGER
	height: INTEGER

	surface: SURFACE
	subways: LINKED_SET [SUBWAY]

	makeBoard(widthParam: INTEGER; heightParam: INTEGER; surfaceParam: SURFACE; subwaysParam: LINKED_SET [SUBWAY])
			-- Initialization for `Current'.
		do
			width:= widthParam
			height:=heightParam
			surface:=surfaceParam
			subways:=subwaysParam
		end

end
