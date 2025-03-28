package com.airbnb.handler;

/**
 * Represents a standardized error response when a requested record is not found in the system.
 * <p>Example JSON response:</p>
 * <pre>
 * {
 *    "status": 404,
 *    "recordType": "house",
 *    "recordId": 1,
 *    "message": "House not found with ID: 1"
 * }
 * </pre>
 *
 * @param status     the HTTP status code (typically 404 Not Found)
 * @param recordType the type of record that was not found (e.g., "house", "user")
 * @param recordId   the ID of the record that was not found (must be positive)
 * @param message    a human-readable error message describing the issue
 * @since 1.0
 */
public record RecordNotFoundResponse(
        int status,
        String recordType,
        long recordId,
        String message
) {
}
