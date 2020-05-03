function Book(bookId, title, authorName) {
    this.bookId = bookId;
    this.title = title;
    this.authorName = authorName;
}

let bookArray = new Array();
bookArray.push(new Book(1, "Goodnight Moon", "Maragaret Wise Brown"));
bookArray.push(new Book(2, "The Very Hungry Caterpillar", "Eric Carle"));
bookArray.push(new Book(3, "The Snowy Day", "Ezra Jack Keats"));
bookArray.push(new Book(4, "Chicka Chicka Boom Boom", "Bill Martin Jr. and John Archambault"));
bookArray.push(new Book(5, "Green Eggs and Ham", "Dr. Seuss"));
bookArray.push(new Book(6, "If You Give a Mouse a Cookie", "Laura Numeroff"));
bookArray.push(new Book(7, "Harold and the Purple Crayon", "Crockett Johnson"));
bookArray.push(new Book(8, "The Little Engine That Could", "Watty Piper"));
bookArray.push(new Book(9, "Knuffle Bunny", "Mo Willems"));
bookArray.push(new Book(10, "Corduroy", "Don Freeman"));
bookArray.push(new Book(11, "Where the Wild Things Are", "Maurice Sendak"));
bookArray.push(new Book(12, "Winnie-the-Pooh", "A. A. Milne"));
bookArray.push(new Book(13, "Madeline", "Ludwig Bemelmans"));
bookArray.push(new Book(14, "The Tale of Peter Rabbit", "Beatrix Potter"));
bookArray.push(new Book(15, "The Giving Tree", "Shel Silverstein"));
bookArray.push(new Book(16, "Beezus and Ramona", "Beverly Cleary"));
bookArray.push(new Book(17, "Where the Sidewalk Ends", "Shel Silverstein"));
bookArray.push(new Book(18, "Charlotte's Web", "E. B. White"));
bookArray.push(new Book(19, "Matilda", "Roald Dahl"));
bookArray.push(new Book(20, "A Wrinkle in Time", "Madeleine L'Engle"));

let pageNumber = 1;
let numToDisplay = 6;
let pages = Math.ceil(bookArray.length / numToDisplay);

let setupEventHandler = function() {
  document.addEventListener("click", () => {
    let node = event.target;
    if(node.className === "page-number") {
      if(node.innerHTML === "&gt;" && pageNumber < pages) {
        console.log(typeof(pageNumber));
        pageNumber += 1;
      } else if (node.innerHTML === "&lt;" && pageNumber > 1) {
        console.log(typeof(pageNumber));
        pageNumber -= 1;
      } else {
        if(node.innerHTML > 0 && node.innerHTML <= pages) {
          pageNumber = parseInt(node.innerHTML);
        }
      }
      console.log(pageNumber);
      performPagination();
    }
  });
}

let getBooksToPaginateFromArray = function(numToDisplay, pageNum, bookArray) {
  let startIndex, endIndex;
  startIndex = (pageNum - 1) * numToDisplay;
  endIndex = startIndex + numToDisplay;
  if(endIndex > bookArray.legth) {
    return bookArray.slice(startIndex, 0);
  }
  return bookArray.slice(startIndex, endIndex);
}

let fillTheTableWithArrayData = function(array){
  let book;
  let bookTable = document.getElementById("book-table");
  bookTable.innerHTML = `<div class="table-header">
  <div class="book-num">#</div>
  <div class="book-title">Title</div> 
  <div class="author">Author</div></div>`;

  for (let i = 0; i < array.length; i++) {
    book = array[i];
    bookTable.innerHTML += `<div class="book-row">
                <div class="book-num">` + book.bookId + `</div>
                <div class="book-title">` + book.title + `</div>
                <div class="author">` + book.authorName + `</div></div>`;
  }
}

let changePageNumberHighlight = function() {
  let pageNumbers = document.getElementsByClassName("page-number");

  for (let i = 0; i < pageNumbers.length; i++) {
    pageNumbers[i].classList.remove("page-highlight");
  }
  pageNumbers[pageNumber].classList.add("page-highlight");
}

let performPagination = function() {
  let slicedArray = getBooksToPaginateFromArray(numToDisplay, pageNumber, bookArray);
  fillTheTableWithArrayData(slicedArray);
  changePageNumberHighlight();
} 

let createThePaginationSelection = function() {
  let pageNumberRow = document.getElementById("page-number-row");
  pageNumberRow.innerHTML += '<button class="page-number"><</button>';
  for(let i = 1; i <= pages; i++) {
    pageNumberRow.innerHTML += '<button class="page-number">'+ i +'</button>';
  }
  pageNumberRow.innerHTML += '<button class="page-number">></button>';
}

createThePaginationSelection();
performPagination();
setupEventHandler();