Feature: Open DemoQA site and validate button Clicks

  Scenario Outline: Open DemoQA website and click on various button
    Given DemoQA website is launched
    When User Clicks on "<button>"
    Then User navigates to Screen with "<pageHeader>" and "<pageContent>"
    And close the browser

    Examples:
      | button     | pageHeader | pageContent                                                   |
      | Draggable  | Draggable  | Allow elements to be moved using the mouse.                   |
      | Droppable  | Droppable  | Create targets for draggable elements.                        |
      | Sortable   | Sortable   | Reorder elements in a list or grid using the mouse.           |
      | Resizable  | Resizable  | Change the size of an element using the mouse.                |
      | Selectable | Selectable | Use the mouse to select elements, individually or in a group. |