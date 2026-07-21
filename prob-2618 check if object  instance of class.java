**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj == null || typeof classFunction !== "function") {
        return false;
    }

    if (obj.constructor === classFunction) {
        return true;
    }

    let proto = Object.getPrototypeOf(obj);

    while (proto !== null) {
        if (proto.constructor === classFunction) {
            return true;
        }
        proto = Object.getPrototypeOf(proto);
    }

    return (
        (classFunction === Number && typeof obj === "number") ||
        (classFunction === String && typeof obj === "string") ||
        (classFunction === Boolean && typeof obj === "boolean") ||
        (classFunction === Symbol && typeof obj === "symbol") ||
        (classFunction === BigInt && typeof obj === "bigint")
    );
};
