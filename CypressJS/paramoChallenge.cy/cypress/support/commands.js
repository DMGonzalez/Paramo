Cypress.Commands.add('initURL', () =>{
    cy.visit('https://demo.casino/user/registration');
    cy.get('.mfp-close',{timeout:20000}).click();
})
Cypress.Commands.add('logConsole',(string)=>{
    cy.log('[====='+string+'=====](http://example.com)');
    console.log('[====='+string+'=====](http://example.com)')
})
Cypress.Commands.add('elementTextDisplayed',(elementText)=>{
    cy.logConsole('Element '+elementText+' is displayed')
})