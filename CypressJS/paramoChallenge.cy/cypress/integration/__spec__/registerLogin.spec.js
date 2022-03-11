const { describe } = require("mocha");

describe('USER REGISTER AND LOGIN WITH USER CREATED',()=>{
    before('OPEN URL',()=>{
        cy.viewport(1024, 768);
        cy.logConsole('Open URL')
        cy.initURL();
    })
    beforeEach('SET CSRF TOKEN',()=>{
        Cypress.Cookies.defaults({
            preserve: ['YII_CSRF_TOKEN', 'session_id']
        })
    })
    it('starting user registration page',()=>{
        cy.get('.page__title',{timeout:15000}).as('titlePage');
        cy.logConsole('Checking page title')
        cy.get('@titlePage').should('contain','Registration');
        cy.logConsole('Page title ok')
    })
    it('registration and login whit user created',function(){
        cy.logConsole('Entering credentials')
        cy.fixture('dataForm').then((user)=>{
            var number = Math.floor(Math.random() * (99999 - 0));
            var emailUser = (user.email+number+user.hotmail)
            cy.logConsole('Registered email is '+emailUser)
            cy.get('[data-test="input-email"]',{timeout:15000}).clear().type(emailUser);
            cy.get('[data-test="input-password"]',{timeout:15000}).clear().type(user.password)
            cy.get('[data-test="input-password_confirmation"]',{timeout:15000}).clear().type(user.password);
        
        cy.get('.input__wrapper > label').as('termsConditions')
        cy.get('@termsConditions').click();
        cy.get('[data-test="control-submit"]',{timeout:15000}).click();
        
        cy.logConsole('Checking user registration')

        cy.get('.notification__title',{timeout:25000}).then((element)=>{
            var titleText = element.text();
            cy.elementTextDisplayed(titleText)
        })
        cy.get('.notification__description',{timeout:15000}).then((element)=>{
            var titleText = element.text();
            cy.elementTextDisplayed(titleText)
        })
        cy.get('.notification__buttons > .button--t1',{timeout:15000}).as('viewProfile')
        .then((element)=>{
            var titleText = element.text();
            cy.elementTextDisplayed(titleText)
        })

        cy.logConsole('User registration successfully')

        cy.get('@viewProfile').click();
        cy.get('.form-avatar__right > .user-info__profile-name',{timeout:15000}).as('profileName')

        cy.logConsole('Getting profile name and user ID')

        cy.get('@profileName').then((element)=>{
            var profileName = element.text();
            cy.logConsole('Profile name is => '+profileName)
        
            cy.get('.profile-info__id > span').as('profileID')
            cy.get('@profileID').then((element)=>{
                var profileID = element.text();
                cy.logConsole('Profile ID is => '+profileID)
                
                cy.logConsole('Checking registered email')

                cy.get('div.profile-menu__item',{timeout:10000}).as('profileSettings')
                cy.get('@profileSettings').click();
                cy.get('.form__input > .selectric-wrapper > .selectric-items > .selectric-scroll > ul > [data-index="2"]',{timeout:15000}).as('contactsMenu')
                cy.get('@contactsMenu').click();
                cy.get('[data-test="input-email"]').should('have.value',emailUser)
                cy.logConsole('Check email: OK')

                cy.get('.mfp-close').click();
                cy.get('.form > .profile__logout > .icon-logout',{timeout:7000}).as('logoutButton')
                cy.get('@logoutButton').click();

                cy.logConsole('Starting login')
                cy.visit('https://demo.casino/user/login')
                cy.get('[data-test="input-username"]',{timeout:15000}).clear().type(emailUser)
                cy.get('[data-test="input-password"]').clear().type(user.password)
                cy.get('[data-test="control-submit"]').click();
                cy.get('.currency--real > .form__input',{timeout:15000})
                cy.get('.mobile-bar--right > [href="/cabinet/profile/index"]',{timeout:15000}).as('profileButton')
                cy.get('@profileButton').click();
                cy.logConsole('LOGIN SUCCESSFULLY')

                cy.logConsole('Checking profile name and user ID')

                cy.get('@profileName',{timeout:15000}).should('have.text',profileName)
                cy.get('@profileID').should('have.text',profileID)
                
                cy.logConsole('TEST SUCCESSFULLY')
                })
            })
        })
    })
})