note
	description: "Summary description for {CATVIEW}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CATVIEW

create
	makeCatView

feature  -- Initialization
	currentPosition: POSITION
	cats,mice,deadMice,entrances: LINKED_SET [COORDINATE]

	makeCatView(currentPositionParam: POSITION; catsParam,miceParam,deadMiceParam,entrancesParam: LINKED_SET [COORDINATE])
			-- Initialization for `Current'.
		do
			currentPosition:=currentPositionParam
			cats:=catsParam
			mice:=miceParam
			deadMice:=deadMiceParam
			entrances:=entrancesParam
		end

end
