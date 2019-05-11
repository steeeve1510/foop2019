note
	description: "Summary description for {MOUSEVIEW}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MOUSEVIEW

create
	makeMouseView

feature  -- Initialization
	isDead: BOOLEAN
	currentPosition: POSITION
	cats,mice,deadMice: LINKED_SET [COORDINATE]
	--subways: DICTIONARY [ INTEGER ,SET[COORDINATE] ]
	goalSubway: SUBWAY

	makeMouseView (isDeadParam: BOOLEAN; currentPositionParam: POSITION; catsParam, miceParam, deadMiceParam: LINKED_SET [COORDINATE]; goalSubwayParam: SUBWAY)
			-- Initialization for `Current'.
		do
			isDead:=isDeadParam
			currentPosition:=currentPositionParam
			cats:=catsParam
			mice:=miceParam
			deadMice:=deadMiceParam
			goalSubway:=goalSubwayParam
		end

end
