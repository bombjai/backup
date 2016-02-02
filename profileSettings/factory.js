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
		    	this.removeBody();
		    	return this.jsonErrorMsg;
		    },
		    addGreenStyle: function() {
		    	$('.ps-wrapper .ps-mob-back').css({'display':'block'});
		    	$('.ps-err-msg-bot, .ps-err-msg-top').addClass('success');
		    	return;

		    },
		    removeBody: function() {
		    	return $('.profile-form, .submitData, .cancel, .note').remove();
		    },
		    confirmMsg: function(val){
		    	return 'New ' + val + ' and Confirmation ' + val + ' did not match. Re-enter both, making sure they are identical.'
		    },
		    defaultErrorMsg: 'Please fill in all the fields',
		    jsonErrorMsg: 'Sorry, there is an error retrieving your information. Please try again later.',
		    updateMsg:'Thank you. Your member information is now updated.'

		}//end return
	        
    }//end function
]);
