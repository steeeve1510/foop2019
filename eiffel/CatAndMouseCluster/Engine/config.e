note
	description: "Summary description for {CONFIG}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	CONFIG

feature -- Access

    height: INTEGER assign setHeight
        attribute
            Result := 10
        end

    width: INTEGER assign setWidth
    	attribute
    		Result:=10
    	end
    numberOfSubways:INTEGER assign setNumberOfSubways
    	attribute
    		Result:=4
    	end
    windowWidth:INTEGER assign setWindowWidth
    	attribute
    		Result:=800
    	end
	windowHeight: INTEGER assign setWindowHeight
		attribute
			Result:=600
		end

feature -- Element change
    setHeight (heightParam :INTEGER)
	do
		height:= heightParam
	end

	setWidth (widthParam :INTEGER)
	do
		width:= widthParam
	end

	setNumberOfSubways (numberOfSubwaysParam :INTEGER)
	do
		numberOfSubways:= numberOfSubwaysParam
	end

	setWindowWidth (windowWidthParam :INTEGER)
	do
		windowWidth:= windowWidthParam
	end

	setWindowHeight (windowHeightParam :INTEGER)
	do
		windowHeight:= windowHeightParam
	end
end
