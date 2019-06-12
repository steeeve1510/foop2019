note
	description: "Summary description for {CONFIGURATION}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CONFIGURATION
create
	make
feature
	make(h: INTEGER; w: INTEGER; w_h: INTEGER; w_w: INTEGER; cats: INTEGER; mice: INTEGER; subs: INTEGER)
	require
		positive: w > 0 and h > 0 and w_h > 0 and w_w > 0 and cats >= 0 and mice >= 0 and subs >= 2
	do
		height := h
		width := w
		window_height := w_h
		window_width := w_w
		number_cat_bots := cats
		number_mouse_bots := mice
		number_subways := subs
	end
feature
	get_height: INTEGER
	do
		Result := height
	end
	get_width: INTEGER
	do
		Result := width
	end
	get_window_width: INTEGER
	do
		Result := window_width
	end
	get_window_height: INTEGER
	do
		Result := window_height
	end
	get_number_cat_bots: INTEGER
	do
		Result := number_cat_bots
	end
	get_number_mouse_bots: INTEGER
	do
		Result := number_mouse_bots
	end
	get_number_subways: INTEGER
	do
		Result := number_subways
	end
feature {NONE}
	height: INTEGER
	width: INTEGER
	window_height: INTEGER
	window_width: INTEGER
	number_cat_bots: INTEGER
	number_mouse_bots: INTEGER
	number_subways: INTEGER
end
