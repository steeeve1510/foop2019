note
	description: "Summary description for {ENGINE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	ENGINE

create
	make

feature  -- Initialization
	config :CONFIG
	make(configParam:CONFIG)
			-- Initialization for `Current'.
		do
			config:=configParam
		end

	run
		do
			
		end

end
