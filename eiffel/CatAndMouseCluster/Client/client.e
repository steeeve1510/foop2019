note
	description: "Summary description for {CLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	CLIENT

feature
	getNextMove : COMMAND
		deferred
		end

	gameOver(winner: STRING)
		deferred
		end
end
