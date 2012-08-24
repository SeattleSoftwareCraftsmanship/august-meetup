/**
 * Created with JetBrains WebStorm.
 * User: tim
 * Date: 8/23/12
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */

var ones = {
    test: function (num) {
        return num < 10;
    },
    getString: function (num) {
        return ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'][num];
    }
};
var tens = {
    test: function (num) {
        return num > 9 && num < 100;
    },
    getString: function (num) {
        if (num > 19) {
            var ten = Math.floor(num / 10);
            var temp = ['zero', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'][ten];
            if (num % 10) {
                temp += ('-' + getString(num - (ten * 10)));
            }
            return temp;
//            return 'tens';
        } else {
            return [
                'ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'
            ][num - 10];
        }
    }
};
var hundreds = {
    test: function (num) {
        return num > 99;
    },
    getString: function (num) {
        var hundred = Math.floor(num / 100);
        var temp = getString(hundred) + ' hundred';
        if (num % 100) {
            temp += (' and ' + getString(num - (hundred * 100)));
        }
        return temp;
    }
};
var segments = [ones, tens, hundreds];

function getSegment (num) {
    for (var s = 0; s < segments.length; s++) {
        var segment = segments[s];
        if (segment.test(num)) {
            return segment;
        }
    }
    throw { exception: 'SegmentNotResolvableExceptions', message: 'Couldn\'t resolve ' + num };
};
function getString (num) {
    var segment = getSegment(num);
    return segment.getString(num);
//    var nextSegment = segment.print(num);
};

for (var i = 0; i < 500; i++) {
    console.log(getString(i));
}
