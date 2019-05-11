note
	description: "Summary description for {PLAYER}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	PLAYER


feature -- Initialization

	isDead : BOOLEAN
		deferred
		end

	getNextMove: COMMAND
		deferred
		end
	update (game: GAME)
		deferred
		end

	gameOver(winner: STRING)
		deferred
		end

	getPosition : POSITION
		deferred
		end

	setPosition (positionParam: POSITION)
		deferred
		end


end
