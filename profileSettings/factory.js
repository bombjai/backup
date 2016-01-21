//profile settings error
serviceModule.factory('profileSettingsCheck', [
    function() {
        return {
        	hideFormSuccess: function() {
        		this.removeBody();
        		this.addGreenStyle();
        		return this.updateMsg;
	        },
		    hideFormFail: function() {
		    	this.remove();
		    	return this.jsonErrorMsg;
		    },
		    addGreenStyle: function() {
		    	return $('.text-error').addClass('success');
		    },
		    removeBody: function() {
		    	return $('.form-item, .form-subhead, .btnSubmit, .description, .note').remove();
		    },
		    defaultErrorMsg: 'Please fill in all the fields',
		    jsonErrorMsg: 'Sorry, there is an error retrieving your information. Please try again later.',
		    updateMsg:'Your Information has been updated',
		    confirmPassMsg: 'New Password and Confirmation Password did not match. Re-enter both, making sure they are identical.'

		}//end return
	        
    }//end function
]);
