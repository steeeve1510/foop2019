note
	description: "Summary description for {CATCLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	CATCLIENT

inherit
	CLIENT

feature
	setCat(cat:CAT)
		deferred
		end

	render(view: CATVIEW)
		deferred
		end
end
