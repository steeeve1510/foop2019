note
	description: "Summary description for {BOARD}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	BOARD
create
	make
feature
	make(w: INTEGER; h: INTEGER; sur: SURFACE; subs: LINKED_LIST[SUBWAY])
	do
		width := w
		height := h
		surface:= sur
		subways := subs
	end
feature
	get_width: INTEGER
	do
		Result := width
	end
	get_height: INTEGER
	do
		Result := height
	end
	get_surface: SURFACE
	do
		Result := surface
	end
	get_subways: LINKED_LIST[SUBWAY]
	do
		Result := subways
	end
feature {NONE}
	width: INTEGER
	height: INTEGER
	surface: SURFACE
	subways: LINKED_LIST[SUBWAY]
	--subway1: SUBWAY
	--subway2: SUBWAY
end
