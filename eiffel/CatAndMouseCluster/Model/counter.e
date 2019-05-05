note
	description: "Summary description for {COUNTER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	COUNTER

create
	make

feature -- Initialization

	subway_counter: INTEGER
	make
			-- Initialization for `Current'.
		do
			subway_counter:=0
		end

	newSubway : INTEGER
		do
			--creates new id for subway
			Result := subway_counter
			subway_counter:=subway_counter+1
		end


end
