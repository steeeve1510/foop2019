note
	description: "Summary description for {MOUSECLIENT}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

deferred class
	MOUSECLIENT

inherit
	CLIENT

feature
	setMouse(mouse:MOUSE)
		deferred
		end
	render(view:MOUSEVIEW)
		deferred
		end
end
