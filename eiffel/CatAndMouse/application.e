note
	description: "CatAndMouse application root class"
	date: "$Date$"
	revision: "$Revision$"

class
	APPLICATION

inherit
	ARGUMENTS_32

create
	make

feature {NONE} -- Initialization
	--temp
 botutil                        :BOTUTIL
 client                         :CLIENT
 catbotclient                   :CATBOTCLIENT
 catclient                      :CATCLIENT
 catview                        :CATVIEW
 mouseclient                    :MOUSECLIENT
 mouseview                      :MOUSEVIEW
 command                        :COMMAND
 movedowncommand                :MOVEDOWNCOMMAND
 moveleftcommand                :MOVELEFTCOMMAND
 moverightcommand               :MOVERIGHTCOMMAND
 moveupcommand                  :MOVEUPCOMMAND
 mousemovedowncommand           :MOUSEMOVEDOWNCOMMAND
 mousemoveleftcommand           :MOUSEMOVELEFTCOMMAND
 mousemoverightcommand          :MOUSEMOVERIGHTCOMMAND
 mousemoveupcommand             :MOUSEMOVEUPCOMMAND

	--temp
	make
			-- Run application.
		local
			coords, coords2: COORDINATE
			subway: SUBWAY
			test: SURFACE
			layer: LAYER
			testSet, secondSet: LINKED_SET[STRING]
		do

			create testSet.make
			create secondSet.make
			testSet.put ("hallo")
			testSet.put ("you")
			across testSet as item loop
				secondSet.put (item.item)
			end
			across secondSet as item loop
				print(item.item)
			end
			layer:=test
			create test.makesurface
			print(test.equals (test))

			print ("Hello Eiffel World!%N")
		end

end
